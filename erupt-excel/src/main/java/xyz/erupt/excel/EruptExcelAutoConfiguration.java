package xyz.erupt.excel;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import xyz.erupt.core.module.EruptModule;
import xyz.erupt.core.module.ModuleInfo;

/**
 * @author YuePeng
 * date 2021/3/28 18:51
 */
@AutoConfiguration
@ComponentScan
public class EruptExcelAutoConfiguration implements EruptModule {

    @Override
    public ModuleInfo info() {
        return ModuleInfo.builder().name("erupt-excel").build();
    }

}
