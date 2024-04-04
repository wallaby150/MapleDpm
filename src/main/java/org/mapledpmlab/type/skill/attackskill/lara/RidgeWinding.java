package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RidgeWinding extends AttackSkill {
    public RidgeWinding() {
        this.setName("산등성이 굽이굽이");
        this.setDamage(660.0);
        this.setAttackCount(4L);
        this.setDelay(960L);
        this.setCooldown(60.0);
        this.addFinalDamage(1.6);   // 코어강화
        this.setDotDuration(4800L);
        this.setInterval(80L);
        this.setLimitAttackCount(60L);
    }
}
