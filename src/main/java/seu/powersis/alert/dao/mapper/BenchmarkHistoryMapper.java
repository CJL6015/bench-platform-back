package seu.powersis.alert.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import seu.powersis.alert.dao.dto.IndexValueDTO;
import seu.powersis.alert.dao.entity.BenchmarkHistory;

import java.util.List;

/**
 * @author 陈小黑
 * @description 针对表【benchmark_history】的数据库操作Mapper
 * @createDate 2023-09-12 22:36:41
 * @Entity seu.powersis.alert.dao.entity.BenchmarkHistory
 */
public interface BenchmarkHistoryMapper extends BaseMapper<BenchmarkHistory> {
    /**
     * 获取统计结果
     *
     * @param modelId   模型id
     * @param type      类型
     * @param indexList 索引
     * @return 统计结果
     */
    List<IndexValueDTO> getIndexValue(Integer modelId, String type, List<Integer> indexList);
}




