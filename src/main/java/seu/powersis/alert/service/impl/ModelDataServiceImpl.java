package seu.powersis.alert.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import seu.powersis.alert.dao.entity.BenchmarkHistory;
import seu.powersis.alert.dao.service.BenchmarkHistoryService;
import seu.powersis.alert.service.ModelDataService;
import seu.powersis.alert.vo.ModelDataVO;

import java.util.ArrayList;
import java.util.List;

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
    public ModelDataVO getModelData(Integer modelId, String type, List<Integer> indexList) {
        LambdaQueryWrapper<BenchmarkHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BenchmarkHistory::getModelId, modelId)
                .eq(StringUtils.hasText(type), BenchmarkHistory::getType, type)
                .orderByAsc(BenchmarkHistory::getTargetvalue);
        List<BenchmarkHistory> list = benchmarkHistoryService.list(queryWrapper);
        List<Double> targetValue = new ArrayList<>();
        List<Integer> sampleValue = new ArrayList<>();
        List<List<Double>> dataList = new ArrayList<>();
        for (Integer ignored : indexList) {
            dataList.add(new ArrayList<>());
        }
        list.forEach(benchmarkHistory -> {
            targetValue.add(benchmarkHistory.getTargetvalue());
            sampleValue.add(benchmarkHistory.getSamplenum());
            for (int i = 0; i < indexList.size(); i++) {
                Integer index = indexList.get(i);
                String propertyName = "b" + (index + 1);
                List<Double> data = dataList.get(i);
                data.add(benchmarkHistory.getPropertyByName(propertyName));
            }
        });
        return  ModelDataVO.builder().dataList(dataList)
                .targetValue(targetValue)
                .sampleValue(sampleValue)
                .build();
    }
}
