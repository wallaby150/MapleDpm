package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarkSpear extends AttackSkill {
    public DarkSpear() {
        this.setName("다크 스피어");
        this.setDamage(715.0);
        this.setAttackCount(7L);
        this.setCooldown(10.0);
        this.setDelay(990L);
        this.setDotDuration(990L);
        this.setInterval(90L);
        this.setLimitAttackCount(11L);
        this.addFinalDamage(1.6);
        this.addIgnoreDefenseList(50L);
        this.setRelatedSkill(new DarkSynthesis());
    }
}
