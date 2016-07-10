/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsd.umc.nodeka.plugin;

import com.lsd.umc.script.ScriptInterface;
import com.lsd.umc.util.AnsiTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Isaac
 */
public class iPet {

    private ScriptInterface script;
    private List<NodekaClass> activePets = new ArrayList<>();

    /*
     [L:0] R:Draalik X:2000000000 G:205023444 A:-372
     [Lag: 0] [Reply: guide] [Align: 797]
     L:0 R: X:442159262
     [L:0] [Ocellaris H:43028/43028 M:8884/8884 S:5001/5001 E:21049/21049] [A:-1000] []
     */
    private static final Pattern nonCombatPrompt = Pattern.compile("^(?:\\[?(?:Lag|L):\\s?\\d+\\]?)\\s\\[?(?:R|Reply|.+ H):?\\s?");
    /*
     [L:0] Ocellaris: (perfect condition) vs. roadrunner: (badly wounded)
     [Lag: 2000] [Coil: (perfect condition)] [novice healer: (covered in blood)]

     [L:0] [Darth H:61211/63111 M:16074/16074 S:15390/15888 E:52997/54001] [A:1000] []
     [Ocellaris](perfect condition) [Bayeshi guard](near death)
     */
    private static final Pattern combatPrompt = Pattern.compile("^(?:\\[?(?:Lag|L):\\s?\\\\d+\\]?)?\\s?(?:.+):\\s?\\((?:.+)\\)|\\[.+]\\(.+\\)\\s");

    public void init(ScriptInterface script) {
        this.script = script;

        script.capture(AnsiTable.getCode("yellow") + "iPet Plugin loaded.\001");
        script.registerCommand("pet", "com.lsd.umc.nodeka.plugin.iPet", "menu");
    }

    public void IncomingEvent(ScriptInterface event) {
        Matcher outOfCombat = nonCombatPrompt.matcher(event.getText());
        Matcher inCombat = combatPrompt.matcher(event.getText());
        Matcher tameAdd = Pattern.compile("^Your tame succeeds as (?:a|an) (.+) sees you as (?:his|her|it's) master\\.").matcher(event.getText());
        Matcher petLost = Pattern.compile("^").matcher(event.getText());

        if (tameAdd.find()) {
            script.capture(AnsiTable.getCode("light red") + ">> " + AnsiTable.getCode("yellow") + "PET ADDED: " + AnsiTable.getCode("white") + tameAdd.group(1) + "\001");
            if ("fire dragon".equals(tameAdd.group(1))) {
                if (script.getAlias("FollowerCreateEvent") != null) {
                    this.script.parse("FollowerCreateEvent");
                }
                activePets.add(new Barbarian(tameAdd.group(1), true));
            }
            if ("black dragon".equals(tameAdd.group(1))) {

            }
            if ("hummingbird".equals(tameAdd.group(1))) {

            }
            if ("fiend".equals(tameAdd.group(1))) {

            }
        }

        if (outOfCombat.find()) {
            for (NodekaClass pet : activePets) {

            }
        }
    }
}
