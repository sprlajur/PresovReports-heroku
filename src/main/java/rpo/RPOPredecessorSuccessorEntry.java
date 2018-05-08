/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpo;

import java.math.BigInteger;

/**
 *
 * @author sprlajur
 */
public class RPOPredecessorSuccessorEntry extends AbstractRPOEntry {

    private BigInteger ico;

    private String name;

    public BigInteger getIco() {
        return ico;
    }

    public void setIco(BigInteger ico) {
        this.ico = ico;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
