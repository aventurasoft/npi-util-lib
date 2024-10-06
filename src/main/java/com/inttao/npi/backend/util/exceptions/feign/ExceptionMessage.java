package com.inttao.npi.backend.util.exceptions.feign;

import lombok.*;

/**
 * ExceptionMessage
 * <p>
 *     This class is used to create a custom message for exceptions from services.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionMessage {
    private String timestamp;
    private int status; // HTTP Status
    private String error;  // HTTP Error code
    private String message; // Exception message
    private String path; // Path of the request
    private String trace; // Stack trace
}
