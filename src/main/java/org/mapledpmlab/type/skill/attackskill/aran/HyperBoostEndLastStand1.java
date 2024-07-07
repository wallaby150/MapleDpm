package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HyperBoostEndLastStand1 extends AttackSkill {
    public HyperBoostEndLastStand1() {
        this.setName("하이퍼 부스트 엔드-라스트 스탠드(1타)");
        this.setDamage(1600.0);
        this.setAttackCount(10L);
        this.setDelayByAttackSpeed(420L);
        this.setApplyFinalAttack(true);
        this.setCooldown(30.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.setRelatedSkill(new HyperBoostEndLastStand2());
    }
}
