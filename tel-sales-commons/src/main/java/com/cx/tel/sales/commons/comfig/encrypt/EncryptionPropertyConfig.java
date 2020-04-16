package com.cx.tel.sales.commons.comfig.encrypt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;

@Configuration
public class EncryptionPropertyConfig {
 
    @Bean(name = "encryptablePropertyResolver")
    public EncryptablePropertyResolver encryptablePropertyResolver() {
        return new EncryptionPropertyResolver();
    }
    class EncryptionPropertyResolver implements EncryptablePropertyResolver {
        @Override
        public String resolvePropertyValue(String value) {
            if (StringUtils.isEmpty(value)) {
                return value;
            }
            if (value.startsWith("DES@")) {
                return resolveDESValue(value.substring(4));
            }
            return value;
        }
        private String resolveDESValue(String value) {
            // 自定义DES密文解密
            return DesUtil.decrypt(value, DesUtil.KEY);
        }
    }
}
