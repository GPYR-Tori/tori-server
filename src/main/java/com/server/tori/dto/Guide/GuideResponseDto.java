package com.server.tori.dto.Guide;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GuideResponseDto {

  public String content;
  private GuideValueDto A_course;
  private GuideValueDto B_course;
  private GuideValueDto C_course;
  private GuideValueDto D_course;
  private GuideValueDto E_course;
  private GuideValueDto F_course;
  private GuideValueDto G_course;
  private GuideValueDto H_course;
  private GuideValueDto I_course;
  private GuideValueDto J_course;
  private GuideValueDto K_course;
  private GuideValueDto L_course;

  // private Map<int,List<GuideValueDto>> 확장성 생각해보기

  public GuideResponseDto(String content, GuideValueDto A_course, GuideValueDto B_course, GuideValueDto C_course,
                          GuideValueDto D_course, GuideValueDto E_course, GuideValueDto F_course,
                          GuideValueDto G_course, GuideValueDto H_course, GuideValueDto I_course,
                          GuideValueDto J_course, GuideValueDto K_course, GuideValueDto L_course) {
    this.content = content;
    this.A_course = A_course;
    this.B_course = B_course;
    this.C_course = C_course;
    this.D_course = D_course;
    this.E_course = E_course;
    this.F_course = F_course;
    this.G_course = G_course;
    this.H_course = H_course;
    this.I_course = I_course;
    this.J_course = J_course;
    this.K_course = K_course;
    this.L_course = L_course;

  }
}

