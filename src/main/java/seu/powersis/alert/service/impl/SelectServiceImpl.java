package seu.powersis.alert.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seu.powersis.alert.dao.entity.SystemCfg;
import seu.powersis.alert.dao.entity.SystemTypeCfg;
import seu.powersis.alert.dao.entity.UnitCfg;
import seu.powersis.alert.dao.service.SystemCfgService;
import seu.powersis.alert.dao.service.SystemTypeCfgService;
import seu.powersis.alert.dao.service.UnitCfgService;
import seu.powersis.alert.param.SelectQuery;
import seu.powersis.alert.service.SelectService;
import seu.powersis.alert.vo.OptionItemVO;
import seu.powersis.alert.vo.SelectAllOptionVO;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-16 22:45
 */
@Service
@RequiredArgsConstructor
public class SelectServiceImpl implements SelectService {
    private final UnitCfgService unitCfgService;

    private final SystemTypeCfgService systemTypeCfgService;

    private final SystemCfgService systemCfgService;

    @Override
    public SelectAllOptionVO getAllOptions() {
        List<UnitCfg> unitCfgList = unitCfgService.list();

        LambdaQueryWrapper<SystemTypeCfg> typeQuery = new LambdaQueryWrapper<>();
        typeQuery.orderByAsc(SystemTypeCfg::getSystemTypeId);
        List<SystemTypeCfg> typeCfgList = systemTypeCfgService.list(typeQuery);

        LambdaQueryWrapper<SystemCfg> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SystemCfg::getSystemTypeId, typeCfgList.get(0).getSystemTypeId())
                .eq(SystemCfg::getUnitId, unitCfgList.get(0).getUnitId())
                .orderByAsc(SystemCfg::getSystemId);
        List<SystemCfg> systemCfgList = systemCfgService.list(queryWrapper);


        List<OptionItemVO> units = unitCfgList.stream().map(o -> OptionItemVO.builder()
                .id(o.getUnitId())
                .name(o.getUnitName().trim())
                .build()).collect(Collectors.toList());
        List<OptionItemVO> types = typeCfgList.stream().map(o -> OptionItemVO.builder()
                .id(o.getSystemTypeId())
                .name(o.getSystemTypeShortname().trim())
                .build()).collect(Collectors.toList());

        List<OptionItemVO> systems = systemCfgList.stream().map(o -> OptionItemVO.builder()
                .id(o.getSystemId())
                .name(o.getSystemName().trim())
                .build()).collect(Collectors.toList());
        systems.add(0,OptionItemVO.builder().id(null).name("全部").build());
        return SelectAllOptionVO.builder()
                .units(units)
                .types(types)
                .systems(systems)
                .build();
    }

    @Override
    public List<OptionItemVO> getSystemOptions(@Valid SelectQuery query) {
        LambdaQueryWrapper<SystemCfg> queryWrapper = new LambdaQueryWrapper<>();
        Integer unitId = query.getUnitId();
        Integer typeId = query.getTypeId();
        queryWrapper.eq(SystemCfg::getSystemTypeId, typeId)
                .eq(SystemCfg::getUnitId, unitId)
                .orderByAsc(SystemCfg::getSystemId);
        List<SystemCfg> systemCfgList = systemCfgService.list(queryWrapper);
        List<OptionItemVO> systems = systemCfgList.stream().map(o -> OptionItemVO.builder()
                        .id(o.getSystemId())
                        .name(o.getSystemName().trim())
                        .build())
                .collect(Collectors.toList());
        systems.add(0,OptionItemVO.builder().id(null).name("全部").build());
        return systems;
    }
}
