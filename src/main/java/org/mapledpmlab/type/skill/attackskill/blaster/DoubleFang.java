package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DoubleFang extends AttackSkill {
    public DoubleFang() {
        this.setName("더블 팡");
        this.setAttackCount(4L);
        this.setDamage(835.0);          //  + 183
        this.setDelay(150L);
        this.setAddDamage(10L);         // 펀치-리인포스
        this.addIgnoreDefenseList(20L); // 펀치-이그노어 가드
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new RevolvingCannonDF());
    }
}
