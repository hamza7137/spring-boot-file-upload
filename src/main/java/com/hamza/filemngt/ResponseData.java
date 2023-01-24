package com.hamza.filemngt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Data annotation for implicitly generate getter & setters
@NoArgsConstructor // For implicitly generate No arg constructor.
@AllArgsConstructor // For implicitly generate parametrised constructor.
public class ResponseData
{
    private String fileName;
    private String downloadURL;
    private String fileType;
    private long fileSize;
}