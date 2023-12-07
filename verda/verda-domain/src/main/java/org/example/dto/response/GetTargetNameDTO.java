package org.example.dto.response;

import lombok.Getter;

@Getter
public class GetTargetNameDTO {
    private String targetName;
    public GetTargetNameDTO(String targetName){
        this.targetName=targetName;
    }
}

