package com.justory.backend.api.external;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PlatformsDTO {
    private Integer id;
    private String name;
    private byte[] img;
    private boolean subscriptionRequired;
    private boolean purchaseOption;
}
