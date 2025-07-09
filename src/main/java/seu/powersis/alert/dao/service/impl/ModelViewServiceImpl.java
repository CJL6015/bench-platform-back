package seu.powersis.alert.dao.service.impl;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import seu.powersis.alert.dao.entity.ModelView;
import seu.powersis.alert.dao.mapper.ModelViewMapper;
import seu.powersis.alert.dao.service.BenchmarkHistoryService;
import seu.powersis.alert.dao.service.ModelViewService;
import seu.powersis.alert.service.ExaService;
import seu.powersis.alert.vo.ModelInfoVO;
import seu.powersis.alert.vo.OptimisticVO;
import seu.powersis.alert.vo.PointVO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 陈小黑
 * @description 针对表【MODEL_VIEW】的数据库操作Service实现
 * @createDate 2024-07-16 22:16:11
 */
@Service
@RequiredArgsConstructor
public class ModelViewServiceImpl extends ServiceImpl<ModelViewMapper, ModelView>
        implements ModelViewService {
    private final BenchmarkHistoryService benchmarkHistoryService;
    private final ExaService exaService;
    @Value("${algorithm.host}")
    private String algorithmHost;

    @Override
    public List<OptimisticVO> getOptimistic(Integer id, String search, String st, String et) {
        LambdaQueryWrapper<ModelView> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(id != null, ModelView::getSystemId, id);
        List<ModelView> list = list(queryWrapper);
        List<OptimisticVO> result = new ArrayList<>();

        for (ModelView modelView : list) {
            String modelInfo = modelView.getModelInfo();
            if (StrUtil.isBlank(modelInfo)) {
                continue;
            }
            ModelInfoVO modelInfoVO = JSON.parseObject(modelInfo, ModelInfoVO.class);
            OptimisticVO vo = new OptimisticVO();
            String description = modelInfoVO.getTargetParameter().getDescription();
            List<String> boundary = modelInfoVO.getBoundaryParameter().stream()
                    .map(PointVO::getDescription).collect(Collectors.toList());
            if (StrUtil.isNotBlank(search) && !description.contains(search) && !JSON.toJSONString(boundary).contains(search)) {
                continue;
            }
            List<String> boundaryPoints = modelInfoVO.getBoundaryParameter().stream()
                    .map(PointVO::getTargetPoint).collect(Collectors.toList());
            String targetPoint = modelInfoVO.getTargetParameter().getTargetPoint();
            Float[] bValue = exaService.getValues(boundaryPoints);
            List<Float> values = Arrays.stream(bValue)
                    .map(t -> {
                        if (t == null) {
                            return -999F;
                        } else {
                            return Float.parseFloat(NumberUtil.decimalFormat("#.##", t));
                        }
                    }).
                    collect(Collectors.toList());
            Float targetValue = exaService.getValues(ListUtil.of(targetPoint))[0];
            String t;
            if (targetValue == null) {
                t = "-999";
            } else {
                t = NumberUtil.decimalFormat("#.##", targetValue);
            }
            vo.setTargetName(description);
            vo.setBoundaryName(JSON.toJSONString(boundary));
            vo.setTargetValue(t);
            vo.setBoundaryValue(JSON.toJSONString(values));
            vo.setHistoryBest(getBest(modelInfoVO, st, et, bValue, modelInfoVO.getTargetParameter().getMarktype()));
            result.add(vo);
        }
        return result;
    }

    public String getBest(ModelInfoVO modelInfoVO, String st, String et, Float[] bValue, String type) {
        Map<String, Object> body = new HashMap<>();
        body.put("model_info", modelInfoVO);
        body.put("st", st);
        body.put("et", et);
        body.put("number", 50);
        body.put("type", type);
        body.put("alg_name", "RF");
        body.put("object_value", ListUtil.of(bValue));
        try (HttpResponse response = HttpUtil.createPost(algorithmHost + "/benchmark")
                .body(JSON.toJSONString(body))
                .execute()) {
            return JSON.parseObject(response.body()).getString("result_list");
        } catch (Exception e) {
            log.error("获取最优值异常", e);
            return e.getMessage();
        }

    }
}




