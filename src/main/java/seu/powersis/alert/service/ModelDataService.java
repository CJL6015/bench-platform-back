package seu.powersis.alert.service;

import seu.powersis.alert.vo.ModelDataVO;

import java.util.Date;
import java.util.List;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-09-05 22:10
 */
public interface ModelDataService {
    /**
     * 获取模型数据
     *
     * @param modelId   模型id
     * @param type      类型
     * @param indexList 边界参数索引
     * @param st        开始时间
     * @param et        结束时间
     * @return 模型数据
     */
    ModelDataVO getModelData(Integer modelId, String type, List<Integer> indexList, Date st, Date et);
}
