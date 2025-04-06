package Test.example.batteryScheduling.controller;


import Test.example.batteryScheduling.DTO.UserRegistDTO;
import Test.example.batteryScheduling.common.CommonResponse;
import Test.example.batteryScheduling.domain.User;
import Test.example.batteryScheduling.DTO.UserLoginDTO;
import Test.example.batteryScheduling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	//  登录
	@PostMapping("/login")
	public CommonResponse<User> login(@RequestBody UserLoginDTO userLoginDto){
		System.out.println("Login:" + userLoginDto.getUsername() + "  PWD: " + userLoginDto.getPassword());
		return userService.login(userLoginDto.getUsername(), userLoginDto.getPassword());
	}

	// 注册
	@PostMapping("/register")
	public CommonResponse<User> register(@RequestBody UserRegistDTO userRegisterDto) {
		System.out.println("RG： " + userRegisterDto.toString());
		// 这里调用 service 层处理注册逻辑
		return userService.register(userRegisterDto);
	}
}
