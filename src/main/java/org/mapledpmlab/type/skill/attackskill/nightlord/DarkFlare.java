package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarkFlare extends AttackSkill {
    public DarkFlare() {
        this.setName("다크 플레어");
        this.setAttackCount(1L);
        this.setDamage(360.0);
        this.setDotDuration(60000L);
        this.setInterval(930L);
        this.setFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
