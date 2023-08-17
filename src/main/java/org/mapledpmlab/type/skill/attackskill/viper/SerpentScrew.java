package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SerpentScrew extends AttackSkill {
    public SerpentScrew() {
        this.setName("서펜트 스크류");
        this.setAttackCount(3L);
        this.setDamage(780.0);
        this.setInterval(240L);
        this.addFinalDamage(1.6);
    }
}
