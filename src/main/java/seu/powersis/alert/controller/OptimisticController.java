package seu.powersis.alert.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seu.powersis.alert.common.model.Result;
import seu.powersis.alert.dao.service.ModelViewService;
import seu.powersis.alert.param.OptimisticQuery;
import seu.powersis.alert.vo.OptimisticVO;

import java.util.List;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2024-07-16 22:08
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/optimistic")
public class OptimisticController {
    private final ModelViewService modelViewService;

    @GetMapping("")
    public Result<List<OptimisticVO>> getOptimistic(OptimisticQuery query) {
        List<OptimisticVO> optimistic = modelViewService.getOptimistic(query.getId(), query.getSearch()
                , query.getSt(), query.getEt());
        return Result.success(optimistic);
    }
}
