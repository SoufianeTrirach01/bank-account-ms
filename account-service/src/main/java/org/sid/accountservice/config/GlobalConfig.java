package org.sid.accountservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")
@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public record GlobalConfig (int p1,int p2){
}
