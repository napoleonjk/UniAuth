package com.dianrong.common.uniauth.server.resource;

import com.dianrong.common.uniauth.common.bean.Response;
import com.dianrong.common.uniauth.common.bean.dto.ProfileDefinitionDto;
import com.dianrong.common.uniauth.common.bean.request.ProfileDefinitionParam;
import com.dianrong.common.uniauth.server.service.ProfileService;
import com.dianrong.common.uniauth.server.util.BeanConverter;
import com.dianrong.common.uniauth.sharerw.interfaces.IProfileRWResource;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Api("Profile操作接口")
@RestController
public class ProfileResource implements IProfileRWResource {

  @Autowired
  private ProfileService profileService;

  @Override
  public Response<ProfileDefinitionDto> getProfileDefinition(Long id) {
    return Response.success(profileService.getProfileDefinition(id));
  }

  @Override
  public Response<ProfileDefinitionDto> addNewProfileDefinition(ProfileDefinitionParam param) {
    return Response.success(profileService.addNewProfileDefinition(param.getName(), param.getCode(),
        param.getDescription(), BeanConverter.convertToModel(param.getAttributes()), param.getDescendantProfileIds()));
  }

  @Override
  public Response<ProfileDefinitionDto> updateProfileDefinition(Long id,
      ProfileDefinitionParam param) {
    return Response
        .success(profileService.updateProfileDefinition(id, param.getName(), param.getCode(),
            param.getDescription(), BeanConverter.convertToModel(param.getAttributes()), param.getDescendantProfileIds()));
  }

  @Override
  public Response<ProfileDefinitionDto> extendProfileDefinition(Long id,
      ProfileDefinitionParam param) {
    return Response.success(profileService.extendProfileDefinition(id, BeanConverter.convertToModel(param.getAttributes()),
        param.getDescendantProfileIds()));
  }
}
