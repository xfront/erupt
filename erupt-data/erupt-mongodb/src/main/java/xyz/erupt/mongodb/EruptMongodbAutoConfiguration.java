package xyz.erupt.mongodb;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import xyz.erupt.core.module.EruptModule;
import xyz.erupt.core.module.EruptModuleInvoke;
import xyz.erupt.core.module.ModuleInfo;

/**
 * @author YuePeng
 * date 2021/3/28 18:51
 */
@AutoConfiguration
@ComponentScan
public class EruptMongodbAutoConfiguration implements EruptModule {

    static {
        EruptModuleInvoke.addEruptModule(EruptMongodbAutoConfiguration.class);
    }

    @Override
    public ModuleInfo info() {
        return ModuleInfo.builder().name("erupt-mongodb").build();
    }

}
