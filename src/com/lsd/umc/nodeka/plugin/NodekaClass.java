/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsd.umc.nodeka.plugin;

import java.util.HashMap;
/**
 *
 * @author Isaac
 */
abstract class NodekaClass {
    abstract HashMap<String, Boolean> getBuffs();
    abstract void setSpells(HashMap<String, Boolean> buffs);
    abstract void processSpells();
}
