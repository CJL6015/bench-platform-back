package seu.powersis.alert.service;

import seu.powersis.alert.param.SelectQuery;
import seu.powersis.alert.vo.OptionItemVO;
import seu.powersis.alert.vo.SelectAllOptionVO;

import java.util.List;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-16 22:44
 */
public interface SelectService {
    /**
     * 获取所有的下拉框选项
     *
     * @return 下拉框选项
     */
    SelectAllOptionVO getAllOptions();

    /**
     * 根据unit id和type id获取系统选项
     *
     * @param query 查询参数
     * @return 系统选项
     */
    List<OptionItemVO> getSystemOptions(SelectQuery query);
}
