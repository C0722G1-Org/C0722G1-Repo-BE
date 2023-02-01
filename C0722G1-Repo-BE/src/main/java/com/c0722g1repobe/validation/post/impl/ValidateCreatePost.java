package com.c0722g1repobe.validation.post.impl;

import com.c0722g1repobe.dto.post.create_post.BaseResponseCreatePost;
import com.c0722g1repobe.dto.post.create_post.CreatePostDto;
import com.c0722g1repobe.repository.customer.CustomerRepository;
import com.c0722g1repobe.repository.post.*;
import com.c0722g1repobe.utils.ResponseStatusEnum;
import com.c0722g1repobe.validation.post.IValidateCreatePost;
import org.springframework.stereotype.Component;

@Component
public class ValidateCreatePost implements IValidateCreatePost {
    private final BaseResponseCreatePost baseResponseCreatePost;
    private final CustomerRepository customerRepository;
    private final DemandTypeRepository demandTypeRepository;
    private final LandTypeRepository landTypeRepository;
    private final WardsRepository wardsRepository;
    private final DirectionRepository directionRepository;
    private final AddressRepository addressRepository;

    public ValidateCreatePost(BaseResponseCreatePost baseResponseCreatePost, CustomerRepository customerRepository, DemandTypeRepository demandTypeRepository, LandTypeRepository landTypeRepository, WardsRepository wardsRepository, DirectionRepository directionRepository, AddressRepository addressRepository) {
        this.baseResponseCreatePost = baseResponseCreatePost;
        this.customerRepository = customerRepository;
        this.demandTypeRepository = demandTypeRepository;
        this.landTypeRepository = landTypeRepository;
        this.wardsRepository = wardsRepository;
        this.directionRepository = directionRepository;
        this.addressRepository = addressRepository;
    }

    /**
     * Create by: BaoDP
     * Date Create: 01/02/2023
     * Description: validate create post dto and create post dto attributes.
     * If attributes is invalid return baseResponseCreatePost with code = INVALID_CODE(422), status = FAIL and custom message base on error.
     * Else return baseResponseCreatePost with code = 200 ,status = SUCCESS and message = "thêm mới thành công"
     *
     * @param createPostDto : an object of class CreatePostDto
     * @return an object of class BaseResponseCreatePost
     */
    @Override
    public BaseResponseCreatePost validateCreatePost(CreatePostDto createPostDto) {
        final int VALID_CODE = 200;

        baseResponseCreatePost.setCreatePostDto(createPostDto);

        if (checkCreatePostDtoIsNull(createPostDto)) return baseResponseCreatePost;
        if (validateCodeCustomer().getCode() != VALID_CODE) return baseResponseCreatePost;
        if (validateIdDemand().getCode() != VALID_CODE) return baseResponseCreatePost;
        if (validateIdLandType().getCode() != VALID_CODE) return baseResponseCreatePost;
        if (validateIdWards().getCode() != VALID_CODE) return baseResponseCreatePost;
        if (validateIdDirection().getCode() != VALID_CODE) return baseResponseCreatePost;
        if (validateNumberAddress().getCode() != VALID_CODE) return baseResponseCreatePost;
        if (validatePrice().getCode() != VALID_CODE) return baseResponseCreatePost;
        if (validateArea().getCode() != VALID_CODE) return baseResponseCreatePost;
        if (validateNote().getCode() != VALID_CODE) return baseResponseCreatePost;
        if (validateAddress().getCode() != VALID_CODE) return baseResponseCreatePost;
        if (validateImageListURL().getCode() != VALID_CODE) return baseResponseCreatePost;
        if (validateNamePost().getCode() != VALID_CODE) return baseResponseCreatePost;

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: check param is null or not, if null then use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @param createPostDto: an object of class CreatePostDto
     * @return true if param is null otherwise return false
     */
    private boolean checkCreatePostDtoIsNull(CreatePostDto createPostDto) {
        if (createPostDto == null) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Vui lòng nhập các thông tin cho bài đăng");
            return true;
        }
        return false;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: set baseResponseCreatePost when had invalid attribute with custom message based on error : code = INVALID_CODE(422), status = FAIL and message = param value
     *
     * @param message : custom message
     */
    private void setBaseResponseCreatePostWhenInvalidWithCustomMessage(String message) {
        final int INVALID_CODE = 422;

        baseResponseCreatePost.setCode(INVALID_CODE);
        baseResponseCreatePost.setStatus(ResponseStatusEnum.FAIL);
        baseResponseCreatePost.setMessage(message);
    }

    /**
     * Create by: BaoDP
     * Date Create: 01/02/2023
     * Description: validate codeCustomer, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate Code of Customer
     */
    private BaseResponseCreatePost validateCodeCustomer() {
        String codeCustomer = baseResponseCreatePost.getCreatePostDto().getCodeCustomer();

        boolean codeCustomerNotExist = customerRepository.findIdByCode(codeCustomer) == null;
        if (codeCustomerNotExist) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Mã khách hàng không tồn tại !");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: validate idDemand, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate idDemand
     */
    private BaseResponseCreatePost validateIdDemand() {
        Long idDemand = baseResponseCreatePost.getCreatePostDto().getIdDemand();

        boolean demandTypeNotExist = demandTypeRepository.findByIdNativeQuery(idDemand) == null;
        if (demandTypeNotExist) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Nhu cầu không tồn tại !");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: validate idLandType, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate idLandType
     */
    private BaseResponseCreatePost validateIdLandType() {
        Long idLandType = baseResponseCreatePost.getCreatePostDto().getIdLandType();

        boolean landTypeNotExist = landTypeRepository.findByIdNativeQuery(idLandType) == null;
        if (landTypeNotExist) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Loại bất động sản không tồn tại");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: validate idWards, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate idWards
     */
    private BaseResponseCreatePost validateIdWards() {
        Long idWards = baseResponseCreatePost.getCreatePostDto().getIdWards();

        boolean wardsNotExist = wardsRepository.findNameByIdNativeQuery(idWards) == null;
        if (wardsNotExist) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Phường/Xã không tồn tại !");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: validate idDirection, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate idDirection
     */
    private BaseResponseCreatePost validateIdDirection() {
        Long idDirection = baseResponseCreatePost.getCreatePostDto().getIdDirection();

        boolean directionNotExist = directionRepository.findByIdNativeQuery(idDirection) == null;
        if (directionNotExist) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Hướng nhà không tồn tại !");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: validate numberAddress, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate numberAddress
     */
    private BaseResponseCreatePost validateNumberAddress() {
        String numberAddress = baseResponseCreatePost.getCreatePostDto().getNumberAddress();

        boolean numberAddressIsNull = numberAddress == null;
        if (numberAddressIsNull) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Địa chỉ nhà không hợp lệ !");
            return baseResponseCreatePost;
        }

        boolean invalidNumberAddressLength = numberAddress.length() > 50 || numberAddress.length() < 5;
        if (invalidNumberAddressLength) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Địa chỉ nhà không đúng (ít hơn 5 kí tự hoặc lớn hơn 50 kí tự) !");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: validate price, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate price
     */
    private BaseResponseCreatePost validatePrice() {
        try {
            Double price = baseResponseCreatePost.getCreatePostDto().getPrice();

            boolean priceIsNull = price == null;
            if (priceIsNull) {
                setBaseResponseCreatePostWhenInvalidWithCustomMessage("Giá tiền không hợp lệ !");
                return baseResponseCreatePost;
            }

            boolean invalidPriceMinMax = price < 1000000 || price > Double.parseDouble("100000000000");
            if (invalidPriceMinMax) {
                setBaseResponseCreatePostWhenInvalidWithCustomMessage("Giá tiền không được hỗ trợ (phải bé hơn 100 tỷ và lớn hơn 1 triệu)");
            }

        } catch (NumberFormatException e) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Giá tiền không hợp lệ (chứa kí tự) !");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: validate area, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate area
     */
    private BaseResponseCreatePost validateArea() {
        try {
            Double area = baseResponseCreatePost.getCreatePostDto().getArea();

            boolean areaIsNull = area == null;
            if (areaIsNull) {
                setBaseResponseCreatePostWhenInvalidWithCustomMessage("Diện tích không hợp lệ !");
                return baseResponseCreatePost;
            }

            boolean invalidPriceMinMax = area < 30 || area > 10000;
            if (invalidPriceMinMax) {
                setBaseResponseCreatePostWhenInvalidWithCustomMessage("Diện tích không được hỗ trợ (phải bé hơn 10000m2 và lớn hơn 30m2)");
            }

        } catch (NumberFormatException e) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Diện tích không hợp lệ (chứa kí tự)!");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: validate note, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate note
     */
    private BaseResponseCreatePost validateNote() {
        String note = baseResponseCreatePost.getCreatePostDto().getNote();

        boolean invalidNoteMaxLength = note.length() > 255;
        if (invalidNoteMaxLength) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Ghi chú thêm không được vượt quá 255 kí tự");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: validate Address, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate Address
     */
    private BaseResponseCreatePost validateAddress() {
        Long idAddress = addressRepository.findIdByNumberAddressAndIdWardsNativeQuery(baseResponseCreatePost.getCreatePostDto().getNumberAddress(), baseResponseCreatePost.getCreatePostDto().getIdWards());

        boolean addressExist = idAddress != null;
        if (addressExist) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Địa chỉ này đã tồn tại bài đăng. Vui lòng kiểm tra lại hoặc liên hệ số điện thoại hỗ trợ !");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: validate imageListURL, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate imageListURL
     */
    private BaseResponseCreatePost validateImageListURL() {
        String imageListURL = baseResponseCreatePost.getCreatePostDto().getImageListURL();

        boolean invalidImageListURLMinMaxLength = imageListURL.length() > 255 || imageListURL.length() == 0;
        if (invalidImageListURLMinMaxLength) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Quá trình upload ảnh xảy ra lỗi. Vui lòng thử lại !");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }

    /**
     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: validate namePost, if it is invalid use method setBaseResponseCreatePostWhenInvalidWithCustomMessage before return
     *
     * @return baseResponseCreatePost after validate namePost
     */
    private BaseResponseCreatePost validateNamePost() {
        String namePost = baseResponseCreatePost.getCreatePostDto().getNamePost();

        boolean invalidNamePostMinMaxLength = namePost.length() > 50 || namePost.length() < 10;
        if (invalidNamePostMinMaxLength) {
            setBaseResponseCreatePostWhenInvalidWithCustomMessage("Tên bài đăng không hợp lệ (Tối đa 50 kí tự và tối thiểu 10 kí tự) !");
            return baseResponseCreatePost;
        }

        return baseResponseCreatePost;
    }
}
