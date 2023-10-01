package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MagnumPunch extends AttackSkill {
    public MagnumPunch() {
        this.setName("매그넘 펀치");
        this.setAttackCount(3L);
        this.setDamage(985.0);          //  + 100 + 130 + 219
        this.setDelay(180L);
        this.setAddDamage(10L);         // 펀치-리인포스
        this.addIgnoreDefenseList(20L); // 펀치-이그노어 가드
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new RevolvingCannonMP());
    }
}
