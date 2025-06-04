package com.decode_code.clean_architecture_spring.domain.bo;

import com.decode_code.clean_architecture_spring.domain.enums.SellerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerBO {

    private Long id;

    private String name;

    private String email;

    private SellerStatus status;

}

