package com.vin.back.application.port.in;

import java.util.List;

import com.vin.back.application.dto.FollowDTO;
import com.vin.back.application.dto.ShortUserDTO;
import com.vin.back.application.dto.UserDTO;

public interface UserCaseUse {
    UserDTO getUserByUsername(String username);
    ShortUserDTO save(ShortUserDTO shortUserDTO);
    List<ShortUserDTO> getFollowers(String username);
    List<ShortUserDTO> getFollowed(String username);
    boolean toggleFollow(FollowDTO followDTO);
}
