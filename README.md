# Chromatic-Aberration

**Chromatic-Aberration** is a Java project developed by Nexus Coding Club designed to simulate and correct chromatic aberration in digital images. Chromatic aberration, or color fringing, occurs when a lens fails to focus all colors at the same point, resulting in color distortions.

## Features

- **Simulation Engine**: Models the effect of chromatic aberration on images.
- **Correction Algorithms**: Corrects color shifts, defringing, and channel misalignment.
- **User Interface**: User-friendly graphical interface for real-time image correction.
- **Performance Optimization**: Efficient processing for large images.
- **Extensibility**: Modular design supports future enhancements.

## Getting Started

To use Chromatic-Aberration, follow these steps:

### Loading and Processing an Image

1. **Load Image**: Load an image from a file using its filename.
2. **Create New Image**: Initialize a new, empty image (`imageNew`) with the same dimensions as the original image.
3. **Define Offsets**: Set up offsets for each color channel (Red, Green, Blue) to correct the aberration.
4. **Process Pixels**:
   - Read RGB values of each pixel from the original image.
   - Apply the defined offsets to adjust the pixel positions.
5. **Update New Image**: Write the adjusted pixel values to `imageNew`.



## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For more information or questions, please contact Nexus Coding Club.


