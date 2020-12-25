package cn.ebing.dog.api.domain.query;

import java.time.LocalDateTime;

public class UserQuery {
    private LocalDateTime createTime;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
