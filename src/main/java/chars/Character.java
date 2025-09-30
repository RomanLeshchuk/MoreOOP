package chars;
import kickstrat.KickStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public abstract class Character {
    private int power;
    private int hp;
    private KickStrategy kickStrategy;

    public void setPower(int power) {
        this.power = Math.max(power, 0);
    }

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }

    public void kick(Character target) {
        kickStrategy.kick(this, target);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
