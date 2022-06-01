package com.webshopclient.product;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private String title, description;
    private int score;
}
