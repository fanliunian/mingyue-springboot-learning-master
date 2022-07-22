package com.csp.mingyue.security.vo;

import com.csp.mingyue.security.model.MingYueUser;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 登录用户信息
 *
 * @author Strive
 * @date 2022/4/22 14:59
 * @description
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserVo implements UserDetails, CredentialsContainer {

  /** 用户 */
  private MingYueUser mingYueUser;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return new BCryptPasswordEncoder().encode(mingYueUser.getPassword());
  }

  @Override
  public String getUsername() {
    return mingYueUser.getUsername();
  }

  /** 账户是否未过期，过期无法验证 */
  @Override
  public boolean isAccountNonExpired() {
    // true：未过期
    return true;
  }

  /**
   * 指定用户是否解锁，锁定的用户无法进行身份验证
   *
   * <p>密码锁定
   */
  @Override
  public boolean isAccountNonLocked() {
    // true：未锁定
    return true;
  }

  /** 指示是否已过期的用户的凭据(密码)，过期的凭据防止认证 */
  @Override
  public boolean isCredentialsNonExpired() {
    // true：未过期
    return true;
  }

  /** 用户是否被启用或禁用。禁用的用户无法进行身份验证。 */
  @Override
  public boolean isEnabled() {
    // true：未禁用
    return true;
  }

  /** 认证完成后，擦除密码 */
  @Override
  public void eraseCredentials() {
    mingYueUser.setPassword(null);
  }
}
