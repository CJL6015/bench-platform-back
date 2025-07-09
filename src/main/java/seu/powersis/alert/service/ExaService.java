package seu.powersis.alert.service;

import seu.powersis.alert.vo.PointOptionItemVO;

import java.util.List;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-20 20:21
 */
public interface ExaService {
    /**
     * 获取测点选项
     *
     * @param search 查询条件
     * @return 选项
     */
    List<PointOptionItemVO> getPointOptionList(String search);

    public Float[] getValues(List<String> points);
}
