package seu.powersis.alert.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import seu.powersis.alert.dao.entity.ModelView;
import seu.powersis.alert.vo.OptimisticVO;

import java.util.List;

/**
 * @author 陈小黑
 * @description 针对表【MODEL_VIEW】的数据库操作Service
 * @createDate 2024-07-16 22:16:11
 */
public interface ModelViewService extends IService<ModelView> {
    /**
     * @param id
     * @param search
     * @return
     */
    List<OptimisticVO> getOptimistic(Integer id, String search, String st, String et);
}
