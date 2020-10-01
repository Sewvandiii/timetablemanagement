/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Sewwandi
 */
public class RawHtmlRenderer extends DefaultTableCellHeaderRenderer{
    
    public RawHtmlRenderer() {
        putClientProperty("html.disable", Boolean.TRUE);
    }
}
