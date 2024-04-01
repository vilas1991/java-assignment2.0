package com.webapp.backend.config;

import com.webapp.backend.grpc.AddressServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {

    @Value("${grpc.address.host}")
    private String grpcHost;

    @Bean("addressServiceBlockingStub")
    public AddressServiceGrpc.AddressServiceBlockingStub initAddressServiceBlockingStub() {
        ManagedChannel channel =
                ManagedChannelBuilder.forTarget(grpcHost)
                        .usePlaintext()
                        .maxInboundMessageSize(1024 * 1024 * 1024)
                        .build();
        return AddressServiceGrpc.newBlockingStub(channel);
    }

}
