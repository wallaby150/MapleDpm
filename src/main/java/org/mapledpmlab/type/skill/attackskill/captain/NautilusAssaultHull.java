package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class NautilusAssaultHull extends AttackSkill {
    public NautilusAssaultHull() {
        this.setName("노틸러스 어썰트(선체 공격)");
        this.setDamage(1320.0);
        this.setAttackCount(6L);
        this.setCooldown(180.0);
        this.setDotDuration(3000L);
        this.setInterval(428L);
        this.setLimitAttackCount(7L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new NautilusAssaultVolleyFire());
    }
}
