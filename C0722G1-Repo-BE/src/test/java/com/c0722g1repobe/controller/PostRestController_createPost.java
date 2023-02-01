package com.c0722g1repobe.controller;

import com.c0722g1repobe.dto.post.create_post.CreatePostDto;
import com.c0722g1repobe.utils.ResponseStatusEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostRestController_createPost {
    /* TẤT CẢ HTTP STATUS CODE ĐỀU TRẢ VỀ 2XX
     * LUÔN GỬI VỀ FRONT-END PROJECT 1 OBJECT BASE RESPONSE CREATE POST CÓ CÁC THUỘC TÍNH :
     * + CODE : HTTP STATUS CODE - CHECK CODE NÀY ĐỂ BIẾT CÓ XẢY RA LỖI HAY KHÔNG, E MẶC ĐỊNH 422 LÀ LỖI VALIDATE VÀ 200 LÀ TẠO MỚI THÀNH CÔNG
     * + STATUS : ENUM RESPONSE STATUS GỒM SUCCESS, FAIL, ERROR
     * + MESSAGE : CHỨA MESSAGE BACKEND GỬI VỀ FRONTEND
     * + CREATEPOSTDTO : OBJECT MÀ FRONT-END ĐÃ GỬI CHO BACK-END */
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPost_createPostDto_13() throws Exception {
        CreatePostDto createPostDto = null;

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Vui lòng nhập các thông tin cho bài đăng"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    private final Long ID_NOT_EXIST = -1L;

    @Test
    void createPost_idCustomer_15() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().idCustomer(ID_NOT_EXIST).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Mã khách hàng không tồn tại !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_idDemand_15() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().idDemand(ID_NOT_EXIST).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Nhu cầu không tồn tại !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_idLandType_15() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().idLandType(ID_NOT_EXIST).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Loại bất động sản không tồn tại !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_idWards_15() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().idWards(ID_NOT_EXIST).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Địa chỉ không phù hợp !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_idDirection_15() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().idDirection(ID_NOT_EXIST).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Hướng nhà không tồn tại !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_numberAddress_15() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().numberAddress(null).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Địa chỉ nhà không hợp lệ !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_numberAddress_16() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().numberAddress("").build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Địa chỉ nhà không đúng (ít hơn 5 kí tự hoặc lớn hơn 50 kí tự) !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_numberAddress_17() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().numberAddress("0123456789012345678901234567890123456789012345678901234567890").build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Địa chỉ nhà không đúng (ít hơn 5 kí tự hoặc lớn hơn 50 kí tự) !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_price_13() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().price(null).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Giá tiền không hợp lệ !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_price_15() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().price(Double.valueOf("abc")).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Giá tiền không hợp lệ (chứa kí tự) !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_price_16() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().price(100000d).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Giá tiền không được hỗ trợ (phải bé hơn 100 tỷ và lớn hơn 1 triệu)"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_price_17() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().price(Double.parseDouble("100000000001")).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Giá tiền không được hỗ trợ (phải bé hơn 100 tỷ và lớn hơn 1 triệu)"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_area_13() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().area(null).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Diện tích không hợp lệ !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_area_15() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().area(Double.valueOf("abc")).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Diện tích không hợp lệ (chứa kí tự)!"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_area_16() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().area(30d).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Diện tích không được hỗ trợ (phải bé hơn 10000m2 và lớn hơn 30m2)"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    @Test
    void createPost_area_17() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().area(10000d).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Diện tích không được hỗ trợ (phải bé hơn 10000m2 và lớn hơn 30m2)"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    /**
     * Validates cho note khi nhều hơn 500 kí tự
     */
    @Test
    void createPost_note_17() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().note("nhiều hơn 500 kí tự").build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Mô tả chi tiết không được vượt quá 255 kí tự"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    /**
     * Kiểm tra xem địa chỉ và id quận/huyện này cùng tồn tại trong table address thay chưa
     */
    @Test
    void createPost_numberAddress_idWards_checkContainAddress() throws Exception {
        Long existIdWardsWithSameNumberAddress = 1L;
        CreatePostDto createPostDto = CreatePostDto.builder().numberAddress("1 địa chỉ đã có sẵn trong database").idWards(existIdWardsWithSameNumberAddress).build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Địa chỉ này đã tồn tại bài đăng. Vui lòng kiểm tra lại hoặc liên hệ số điện thoại hỗ trợ !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    /**
     * Validates cho imagelistUrl khi nhiều hơn 255 kí tự
     */
    @Test
    void createPost_imageListURL_17() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().imageListURL("nhiều hơn 255 kí tự").build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Quá trình upload ảnh xảy ra lỗi. Vui lòng thử lại !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    /**
     * Validates cho imagelistUrl khi rỗng
     */
    @Test
    void createPost_imageListURL_14() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().imageListURL("").build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Quá trình upload ảnh xảy ra lỗi. Vui lòng thử lại !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    /**
     * Validates cho namePost khi nhiều hơn 50 kí tự
     */
    @Test
    void createPost_namePost_17() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().namePost("nhiều hơn 50 kí tự").build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Tên bài đăng không hợp lệ (Tối đa 50 kí tự và tối thiểu 10 kí tự) !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }

    /**
     * Validates cho namePost khi ít hơn 5 kí tự
     */
    @Test
    void createPost_namePost_16() throws Exception {
        CreatePostDto createPostDto = CreatePostDto.builder().namePost("ít hơn 50 kí tự").build();

        this.mockMvc.perform(MockMvcRequestBuilders.post("api/post/create")
                        .content(this.objectMapper.writeValueAsString(createPostDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value(422))
                .andExpect(jsonPath("status").value(ResponseStatusEnum.FAIL))
                .andExpect(jsonPath("message").value("Tên bài đăng không hợp lệ (Tối đa 50 kí tự và tối thiểu 10 kí tự) !"))
                .andExpect(jsonPath("createPostDto").value(this.objectMapper.writeValueAsString(createPostDto)));
    }
}
