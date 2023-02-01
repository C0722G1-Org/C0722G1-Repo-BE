package com.c0722g1repobe.dto.form;
import com.c0722g1repobe.entity.form.DetailForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
public class DataFormDto implements Validator {
    private Long idDataForm;
    private String codeDataForm;
    private String contentDataForm;
    private DetailForm detailForm;

    public DataFormDto() {
    }

    public DataFormDto(Long idDataForm, String codeDataForm, String contentDataForm, DetailForm detailForm) {
        this.idDataForm = idDataForm;
        this.codeDataForm = codeDataForm;
        this.contentDataForm = contentDataForm;
        this.detailForm = detailForm;
    }

    public Long getIdDataForm() {
        return idDataForm;
    }

    public void setIdDataForm(Long idDataForm) {
        this.idDataForm = idDataForm;
    }

    public String getCodeDataForm() {
        return codeDataForm;
    }

    public void setCodeDataForm(String codeDataForm) {
        this.codeDataForm = codeDataForm;
    }

    public String getContentDataForm() {
        return contentDataForm;
    }

    public void setContentDataForm(String contentDataForm) {
        this.contentDataForm = contentDataForm;
    }

    public DetailForm getDetailForm() {
        return detailForm;
    }

    public void setDetailForm(DetailForm detailForm) {
        this.detailForm = detailForm;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        DataFormDto dataFormDto = (DataFormDto) target;
        if (!dataFormDto.getContentDataForm().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")){
            errors.rejectValue("contentDataForm", "contentDataForm", "1.\tTên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa");
        }
        if (!dataFormDto.getCodeDataForm().matches("^HS-[0-9]{3}$")){
            errors.rejectValue("codeDataForm", "codeDataForm", "Mã phải bắt đầu là HS- và có 3 chữ số");
        }
    }
}
