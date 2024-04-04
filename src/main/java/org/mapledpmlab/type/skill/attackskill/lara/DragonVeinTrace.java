package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonVeinTrace extends AttackSkill {
    public DragonVeinTrace() {
        this.setName("용맥의 자취");
        this.setDamage(500.0 + 57);
        this.setAttackCount(2L);
        this.setCooldown(1.0);
        this.setDelayByAttackSpeed(120L);
    }
}
