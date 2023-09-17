package seu.powersis.alert.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import seu.powersis.alert.common.enums.Algorithm;
import seu.powersis.alert.common.enums.ModelStatus;
import seu.powersis.alert.common.enums.ModelTrash;
import seu.powersis.alert.common.enums.ModelVisible;
import seu.powersis.alert.common.model.ModelInfo;
import seu.powersis.alert.dao.entity.ModelCfg;
import seu.powersis.alert.dao.service.ModelCfgService;
import seu.powersis.alert.param.CreateModelInfo;
import seu.powersis.alert.param.ModelSelectQuery;
import seu.powersis.alert.service.ModelService;
import seu.powersis.alert.vo.ModelInfoVO;
import seu.powersis.alert.vo.ModelSimpleVO;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 13:22
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelCfgService modelCfgService;

    @Override
    public List<ModelSimpleVO> getModelList(ModelSelectQuery query) {
        Integer systemId = query.getSystemId();
        String modelName = query.getName();
        Integer status = query.getStatus();
        Integer trash = query.getTrash();
        LambdaQueryWrapper<ModelCfg> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Objects.nonNull(systemId), ModelCfg::getSystemId, systemId)
                .eq(Objects.nonNull(status), ModelCfg::getStatus, status)
                .eq(Objects.nonNull(trash), ModelCfg::getTrash, trash)
                .eq(ModelCfg::getVisible, ModelVisible.VISIBLE.code)
                .like(StringUtils.hasLength(modelName), ModelCfg::getModelName, modelName);
        List<ModelCfg> list = modelCfgService.list(queryWrapper);
        return list.stream().map(modelCfg -> ModelSimpleVO.builder()
                        .id(modelCfg.getModelId())
                        .name(modelCfg.getModelName().trim())
                        .creatName(modelCfg.getCreatName())
                        .creatTime(modelCfg.getCreatTime())
                        .status(modelCfg.getStatus())
                        .algorithm(Algorithm.of(modelCfg.getAlgorithmId()).toString())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public ModelInfoVO getModelInfo(Integer id) {
        LambdaQueryWrapper<ModelCfg> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ModelCfg::getModelId, id);
        ModelCfg model = modelCfgService.getOne(queryWrapper);
        String modelInfo = model.getModelInfo();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            ModelInfo info = objectMapper.readValue(modelInfo, ModelInfo.class);
            ModelInfoVO vo = new ModelInfoVO();
            BeanUtil.copyProperties(info, vo);
            vo.setCreateName(model.getCreatName());
            vo.setCreateTime(model.getCreatTime());
            vo.setCondition(model.getCondition());
            return vo;
        } catch (JsonProcessingException e) {
            log.error("model info:{}解析失败", modelInfo, e);
        }
        return null;
    }

    @Override
    public Integer createModel(CreateModelInfo model) {
        try {
            ModelInfoVO modelInfo = model.getModelInfo();
            ModelInfo info = new ModelInfo();
            BeanUtil.copyProperties(modelInfo, info);
            ObjectMapper objectMapper = new ObjectMapper();
            ModelCfg cfg = ModelCfg.builder()
                    .systemId(model.getSystemId())
                    .algorithmId(1)
                    .modelName(modelInfo.getModelName())
                    .creatName("admin")
                    .visible(ModelVisible.VISIBLE.code)
                    .status(ModelStatus.TRAINING.code)
                    .trash(ModelTrash.NORMAL.code)
                    .creatTime(new Date())
                    .modelInfo(objectMapper.writeValueAsString(info))
                    .build();
            modelCfgService.save(cfg);
            info.setId(cfg.getModelId());
            cfg.setModelInfo(objectMapper.writeValueAsString(info));
            modelCfgService.updateById(cfg);
            return cfg.getModelId();
        } catch (JsonProcessingException e) {
            log.error("新建模型异常,model:{}", model);
        }

        return -1;
    }

    @Override
    public Boolean updateModelInfo(ModelInfoVO modelInfo) {
        ModelInfo entity = new ModelInfo();
        try {
            BeanUtil.copyProperties(modelInfo, entity);
            ObjectMapper objectMapper = new ObjectMapper();
            String info = objectMapper.writeValueAsString(entity);
            LambdaUpdateWrapper<ModelCfg> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.set(ModelCfg::getModelInfo, info)
                    .eq(ModelCfg::getModelId, modelInfo.getId());
            return modelCfgService.update(updateWrapper);
        } catch (JsonProcessingException e) {
            log.error("模型序列化异常,{}", entity, e);
        }
        return false;
    }
}
