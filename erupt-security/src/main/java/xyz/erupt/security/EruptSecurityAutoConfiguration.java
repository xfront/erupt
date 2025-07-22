package xyz.erupt.security;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties
public class EruptSecurityAutoConfiguration implements EruptModule {

    static {
        EruptModuleInvoke.addEruptModule(EruptSecurityAutoConfiguration.class);
    }

    @Override
    public ModuleInfo info() {
        return ModuleInfo.builder().name("erupt-security").build();
    }

}
