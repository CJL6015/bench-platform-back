package seu.powersis.alert.service;

import seu.powersis.alert.param.CreateModelInfo;
import seu.powersis.alert.param.ModelSelectQuery;
import seu.powersis.alert.vo.ModelInfoVO;
import seu.powersis.alert.vo.ModelSimpleVO;

import java.util.List;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 13:22
 */
public interface ModelService {
    /**
     * 获取模型列表
     *
     * @param query 请求参数
     * @return model 列表
     */
    List<ModelSimpleVO> getModelList(ModelSelectQuery query);

    /**
     * 获取模型信息
     *
     * @param id 模型id
     * @return 模型信息
     */
    ModelInfoVO getModelInfo(Integer id);

    /**
     * 新建模型
     *
     * @param model 模型参数
     * @return 模型id
     */
    Integer createModel(CreateModelInfo model);
}
