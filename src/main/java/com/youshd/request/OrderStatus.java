package com.youshd.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class OrderStatus {
    private String angela;
    private String maria;
    private String bob;
    private String meggieb;
    private String jimi;
    private String hendrix;
    private String nusrat;
}
