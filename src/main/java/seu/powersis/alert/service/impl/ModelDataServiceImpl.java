package seu.powersis.alert.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import seu.powersis.alert.dao.entity.BenchmarkHistory;
import seu.powersis.alert.dao.service.BenchmarkHistoryService;
import seu.powersis.alert.service.ModelDataService;
import seu.powersis.alert.vo.ModelDataVO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-09-05 22:11
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ModelDataServiceImpl implements ModelDataService {

    private final BenchmarkHistoryService benchmarkHistoryService;

    @Override
    public ModelDataVO getModelData(Integer modelId, String type, List<Integer> indexList, Date st, Date et) {

        LambdaQueryWrapper<BenchmarkHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BenchmarkHistory::getModelId, modelId)
                .eq(StringUtils.hasText(type), BenchmarkHistory::getType, type)
                .ge(BenchmarkHistory::getStarttime, st)
                .le(BenchmarkHistory::getEndtime, et);
        List<BenchmarkHistory> list = benchmarkHistoryService.list(queryWrapper);
        List<Double> targetValue = new ArrayList<>();
        int[] sampleValue = new int[10];
        List<List<Double>> dataList = new ArrayList<>();
        for (Integer ignored : indexList) {
            dataList.add(new ArrayList<>());
        }
        int[][] matrix = new int[10][10];
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        List<int[]> heatData = new ArrayList<>();
        list.forEach(benchmarkHistory -> {
            targetValue.add(Double.parseDouble(decimalFormat.format(benchmarkHistory.getTargetvalue())));
            for (int i = 0; i < indexList.size(); i++) {
                Integer index = indexList.get(i);
                String propertyName = "b" + (index + 1);
                String indexName = "b" + (index + 1) + "Id";
                Object propertyByName = benchmarkHistory.getPropertyByName(indexName);
                if (Objects.nonNull(propertyByName)) {
                    int sampleIndex = ((int) propertyByName) - 1;
                    sampleValue[sampleIndex] += benchmarkHistory.getSamplenum();
                }

                List<Double> data = dataList.get(i);
                Object propertyByName1 = benchmarkHistory.getPropertyByName(propertyName);
                if (Objects.nonNull(propertyByName1)) {
                    double property = (double) propertyByName1;
                    property = Double.parseDouble(decimalFormat.format(property));
                    data.add(property);
                } else {
                    data.add(-9999D);
                }

            }
            String bId = benchmarkHistory.getBId();
            String[] split = bId.split("-");
            int xIndex = Integer.parseInt(split[1]) - 1;
            int yIndex = Integer.parseInt(split[2]) - 1;
            matrix[xIndex][yIndex] += benchmarkHistory.getSamplenum();
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                heatData.add(new int[]{i, j, matrix[i][j]});
            }
        }
        return ModelDataVO.builder().dataList(dataList)
                .targetValue(targetValue)
                .sampleValue(sampleValue)
                .heatData(heatData)
                .build();
    }
}
