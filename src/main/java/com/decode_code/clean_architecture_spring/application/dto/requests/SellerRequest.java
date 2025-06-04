package com.decode_code.clean_architecture_spring.application.dto.requests;

import com.decode_code.clean_architecture_spring.domain.enums.SellerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerRequest {

    private Long id;

    private String name;

    private String email;

    private SellerStatus status;

}
