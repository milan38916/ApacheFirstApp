package com.apachefirst.modalWindows;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.extensions.ajax.markup.html.AjaxLazyLoadPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.image.NonCachingImage;
import org.apache.wicket.markup.html.image.resource.BufferedDynamicImageResource;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.DynamicImageResource;

import java.util.Spliterator;
import java.util.function.Consumer;

public class ModalDialogInputPhotoContent extends WebPage
{

    private FileUploadField fileUpload;
    private byte[] image;
    private NonCachingImage imagePreview;

    public ModalDialogInputPhotoContent(String id)
    {
        imagePreview = new NonCachingImage("preview");
        imagePreview.setVisible(false);
        add(imagePreview);

        Form<?> form = new Form<Void>("photoForm") {
            @Override
            protected void onSubmit() {
                super.onSubmit();
                FileUpload uploadFile = fileUpload.getFileUpload();
                if (uploadFile != null) {
                    imagePreview.setVisible(false);
                    image = uploadFile.getBytes();
                    DynamicImageResource dynamicImageResource = new DynamicImageResource() {
                        @Override
                        protected byte[] getImageData(Attributes attributes) {
                            return image;
                        }
                    };
                    imagePreview.setImageResource(dynamicImageResource);
                    imagePreview.setVisible(true);

                }
            }
        };

        form.add(new AttributeModifier("class", "inputBox"));
        form.setMultiPart(true);
        form.add(fileUpload = new FileUploadField("photoUpload"));
        add(form);


    }
}
