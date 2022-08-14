package com.poornima.writerapplication.valueobject;

import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Request {
    @NonNull
    String writeString;
    List<Operation> operations ;

}
