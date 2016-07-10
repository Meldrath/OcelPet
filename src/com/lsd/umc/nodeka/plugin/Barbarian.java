/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsd.umc.nodeka.plugin;

import com.lsd.umc.script.ScriptInterface;
import java.util.HashMap;

/**
 *
 * @author Isaac
 */
class Barbarian extends NodekaClass {

    private boolean isPet;
    private String name;
    public HashMap<String, Boolean> buffs;
    private ScriptInterface script;

    public Barbarian() {
        if (script.getVariable("UMC_NAME") != null) {
            this.name = script.getVariable("UMC_NAME");
        }
        this.isPet = false;
    }

    public Barbarian(String petName, boolean isPet) {
        this.name = petName;
        this.isPet = isPet;
    }

    @Override
    public HashMap<String, Boolean> getBuffs() {
        return this.buffs;
    }

    @Override
    public void setSpells(HashMap<String, Boolean> buffs) {
    }

    @Override
    void processSpells() {
        this.script.send("order followers emote belonging to " + this.script.getVariable("UMC_NAME") + " is no longer lagged.");
    }

}
