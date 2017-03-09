/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mira
 */
@XmlRootElement
public class JaxBean {
    @XmlElement public String name;
    @XmlElement public String pass;
    @XmlElement public String uuid;
}
